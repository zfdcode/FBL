package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Vote;
import com.tum.fbl.core.bdo.VotingPeriod;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.VotingIngItem.VotingIngItem;
import com.tum.fbl.core.persistence.VotingIngItem.VotingIngItemDao;
import com.tum.fbl.core.persistence.VotingPeriod.VotingPeriodDao;
import com.tum.fbl.core.persistence.ingredient.Ingredient;
import com.tum.fbl.core.persistence.ingredient.IngredientDao;
import com.tum.fbl.core.persistence.vote.VoteDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by MS on 10.07.2017.
 */


@Path("/votingPeriod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "VotingPeriod API", description = "Provides the voting Period info.")
public class VotingPeriodResource {

    private final ConnectionFactory connectionFactory;

    /*
     * Connects to the factory for VotingPeriod resource.
     * @param connectionFactory the connection of factory
     */

    public VotingPeriodResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets vote.
     * @param isFinished the variable of VotingPeriod
     * @return List of VotingPeriods
     */

    @GET
    @Path("/{isFinished}")
    @ApiOperation(value = "Get basic vote information")
    public List<VotingPeriod> getAllVotingPeriodsByFinished (@PathParam("isFinished") boolean isFinished) {

        try (VotingPeriodDao votingPeriodDao =this.connectionFactory.getConnection().open(VotingPeriodDao.class)) {
            //com.tum.fbl.core.persistence.vote.Vote vote = voteDao.findVoteById(voteId);
            List<com.tum.fbl.core.persistence.VotingPeriod.VotingPeriod> votingPeriods = votingPeriodDao.getAllVotingPeriodsByFinished(isFinished);
            List<VotingPeriod> VotingPeriodList = null;

            try(VotingIngItemDao votingIngItemDao =this.connectionFactory.getConnection().open(VotingIngItemDao.class)){

                try(IngredientDao ingredientDao =this.connectionFactory.getConnection().open(IngredientDao.class)){

                    try(VoteDao voteDao =this.connectionFactory.getConnection().open(VoteDao.class)){


                        votingPeriods.forEach((period) -> {
                            //List for VotingIngItems to be added to votingPerods
                            List<com.tum.fbl.core.bdo.VotingIngItem> votingIngItemList = new ArrayList<com.tum.fbl.core.bdo.VotingIngItem>();

                            //Build List with all votingIngItems for this period. n-1 relationship.
                            List<com.tum.fbl.core.persistence.VotingIngItem.VotingIngItem> votingIngItems = votingIngItemDao.findVotingIngItemsByPeriod(period.getVotingPeriodId());

                            votingIngItems.forEach((votingIng) -> {
                               //Get the Ingredients for each votingIngItem. 1-1 relationship
                                com.tum.fbl.core.persistence.ingredient.Ingredient ingredient = ingredientDao.findIngredientById(votingIng.getIngredientId());

                                //Get the Votes for each votingIngItem. n-1 relationship
                                List<com.tum.fbl.core.persistence.vote.Vote> votes = voteDao.findVotesByIngItemId(votingIng.getVotingIngItemId());

                                List<com.tum.fbl.core.bdo.Vote> votesList = new ArrayList<Vote>();

                                //Build ingredient BDO
                                if (ingredient != null) {
                                    com.tum.fbl.core.bdo.Ingredient thatIng = new com.tum.fbl.core.bdo.Ingredient(ingredient);


                                //Build votes BDO
                                votes.forEach((vote) -> {
                                    if(vote != null){
                                        Vote thatVote = new Vote(vote);
                                        //Push Vote as bdo to list
                                        votesList.add(thatVote);
                                    }
                                });

                                if(votingIng != null){
                                    //Create VotingIngItem bdo
                                    com.tum.fbl.core.bdo.VotingIngItem thatVo = new com.tum.fbl.core.bdo.VotingIngItem(votingIng, thatIng, votesList);
                                    //Push VoteIngItem to List
                                    votingIngItemList.add(thatVo);
                                }
                            }

                            });

                            //Build BDO
                            if(period != null){
                                VotingPeriod thatVP = new VotingPeriod(period, votingIngItemList);
                                VotingPeriodList.add(thatVP);
                            }
                        });

                        //Return Voting Period List for result.
                        return VotingPeriodList;



                    }


                }


            }

        }
    }
}

