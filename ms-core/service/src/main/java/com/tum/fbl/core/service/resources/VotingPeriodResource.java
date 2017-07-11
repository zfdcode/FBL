package com.tum.fbl.core.service.resources;

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

/**
 * Created by MS on 10.07.2017.
 */

/*
@Path("/votingPeriod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "VotingPeriod API", description = "Provides the voting Period info.")
public class VotingPeriodResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects to the factory for VotingPeriod resource.
     * @param connectionFactory the connection of factory
     /*

    public VotingPeriodResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets vote.
     * @param isFinished the variable of VotingPeriod
     * @return List of VotingPeriods
     */
/*
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
                            List<com.tum.fbl.core.bdo.VotingIngItem> votingIngItemList = null;

                            //Build List with all votingIngItems for this period. n-1 relationship.
                            List<com.tum.fbl.core.persistence.VotingIngItem.VotingIngItem> votingIngItems = votingIngItemDao.findVotingIngItemsByPeriod(period.getVotingPeriodId());

                            votingIngItems.forEach((votingIng) -> {
                               //Get the Ingredients for each votingIngItem. 1-1 relationship
                                com.tum.fbl.core.persistence.ingredient.Ingredient ingredient = ingredientDao.findIngredientById(votingIng.getIngredientId());

                                //Get the Votes for each votingIngItem. n-1 relationship
                                List<com.tum.fbl.core.persistence.vote.Vote> votes = voteDao.findVotesByIngItemId(votingIng.getVotingIngItemId());

                                List<com.tum.fbl.core.bdo.Vote> votesList = null;

                                //Build ingredient BDO
                                new Ingredient(ingredient);

                                //Build votes BDO
                                votes.forEach((vote) -> {
                                    new Vote(vote);
                                    //Push Vote as bdo to list
                                    votesList.add(Vote);



                                });

                                //Create VotingIngItem bdo
                                new VotingIngItem(votingIng);

                                //Set ingredient as attribute to Vote
                                VotingIngItem.setIngredient(Ingredient);

                                //Set votes as attribute to VotingIngItem
                                VotingIngItem.setVotes(votesList);

                                //Push VoteIngItem to List
                                votingIngItemList.add(VotingIngItem);

                            });

                            new VotingPeriod(period);
                            VotingPeriod.setVotingIngItems(votingIngItemList);

                            VotingPeriodList.add(VotingPeriod);

                        });

                        return VotingPeriodList;



                    }


                }


            }


            return List;
        }
    }
}
*/