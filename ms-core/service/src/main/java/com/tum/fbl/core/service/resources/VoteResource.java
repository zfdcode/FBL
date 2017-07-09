package com.tum.fbl.core.service.resources;

/**
 * Created by zfngd on 2017/6/26.
 */

import com.tum.fbl.core.bdo.Vote;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.vote.VoteDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Vote API", description = "Provides the vote information.")
public class VoteResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects to the factory for vote resource.
     * @param connectionFactory the connection of factory
     */
    public VoteResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets vote.
     * @param voteId the vote id
     * @return Vote
     */
    @GET
    @Path("/{voteId}")
    @ApiOperation(value = "Get basic vote information")
    public Vote getVote (@PathParam("voteId") int voteId) {

        try (VoteDao voteDao=this.connectionFactory.getConnection().open(VoteDao.class)) {
            com.tum.fbl.core.persistence.vote.Vote vote = voteDao.findVoteById(voteId);

            return null;
        }
    }
}
