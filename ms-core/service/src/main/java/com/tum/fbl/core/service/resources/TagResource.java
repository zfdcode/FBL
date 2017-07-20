package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Tag;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.tag.TagDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MS on 14.07.2017.
 */
@Path("/tag")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Tag API", description = "Provides ingredients tags.")
public class TagResource {

    private final ConnectionFactory connectionFactory;
    /**
     * Connects to the factory for speacial need resource.
     *
     * @param connectionFactory the connection of factory
     */
    public TagResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all special needs.
     *
     * @return List<Tag> the list of tags
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered tags")
    public List<Tag> getAllTags() {
        try (TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)) {
            List<com.tum.fbl.core.persistence.tag.Tag> tags = tagDao.getAllTags();

            List<com.tum.fbl.core.bdo.Tag> tagsBdo = new ArrayList<>();
            if (tags != null) {
                for (com.tum.fbl.core.persistence.tag.Tag tag : tags) {
                    com.tum.fbl.core.bdo.Tag newTag = new com.tum.fbl.core.bdo.Tag(tag);
                    tagsBdo.add(newTag);
                }
            }

            return tagsBdo;
        }
    }

    @POST
    @ApiOperation(value = "Get all offered tags")
    public int addTag(Tag tag) {
        try (TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)) {
            if (tag!=null) {
                String tagDescription = tag.getTagDescription()==null?"":tag.getTagDescription();
                return tagDao.newTag(tag.getTagName(),tagDescription);
            } else {
                return -1;
            }
        }
    }

    //select tagDescription, name from (Ingredient join (Tag join Tag on tagId) on ingredientId) where ingridientId = X

}
