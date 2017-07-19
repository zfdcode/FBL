package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.bdo.VotingOrderList;
import com.tum.fbl.core.persistence.VotingOrderList.VotingOrderListDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MS on 19.07.2017.
 */
@Path("/votingOrderList")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "votingOrderList API", description = "Provides the voting order list info.")
public class VotingOrderListResource {

    private final ConnectionFactory connectionFactory;

    /*
     * Connects to the factory for VotingPeriod resource.
     * @param connectionFactory the connection of factory
     */

    public VotingOrderListResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;

    }

    @POST
    @ApiOperation(value = "Create a new votingOrderList")
    public void newVotingOrderList(VotingOrderList votingOrder) {
        try (VotingOrderListDao votingOrderListDao = this.connectionFactory.getConnection().open(VotingOrderListDao.class)) {

            //insert new vote
            votingOrderListDao.newVotingOrderList(
                    votingOrder.getOrderedAmount(),
                    votingOrder.getOrderedAt(),
                    votingOrder.getVotingPeriodId(),
                    votingOrder.getIngredientId()
            );
        }
    }

}