package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.VotingIngItem;
import com.tum.fbl.core.persistence.VotingIngItem.VotingIngItemDao;
import com.tum.fbl.core.persistence.ConnectionFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by MS on 21.07.2017.
 */
@Path("/votingIngItem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "VotingIngItem API", description = "Provides the votingIngItem information.")
public class VotingIngItemResource {


    private final ConnectionFactory connectionFactory;
    /**
     * Connects to the factory for votingIngItem resource.
     * @param connectionFactory the connection of factory
     */
    public VotingIngItemResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @POST
    @ApiOperation(value = "Add new VotingIngItem")
    public int addVotingIngItem(VotingIngItem votingIngItem) {
        try (VotingIngItemDao votingIngItemDao = this.connectionFactory.getConnection().open(VotingIngItemDao.class)) {

            return votingIngItemDao.newVotingIngItem(
                    votingIngItem.getVotingIngItemId(),
                    votingIngItem.getVotingPeriodId(),
                    votingIngItem.isIgnored(),
                    votingIngItem.getVotingPeriodId());
            }


        }
    }
