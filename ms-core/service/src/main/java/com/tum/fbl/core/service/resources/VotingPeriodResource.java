package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.VotingPeriod;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.VotingPeriod.VotingPeriodDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by MS on 10.07.2017.
 */
@Path("/votingPeriod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "VotingPeriod API", description = "Provides the voting Period info.")
public class VotingPeriodResource {

    private final ConnectionFactory connectionFactory;

    /**
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
            
            return null;
        }
    }
}
