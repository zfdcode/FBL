package com.tum.fbl.core.persistence.tag;

import com.tum.fbl.core.persistence.ingredient.Ingredient;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper(TagMapper.class)
public interface TagDao extends AutoCloseable{

    @SqlQuery("select * from tag")
    List<Tag> getAllTags();

    @SqlQuery("select tagName from (Ingredient join (IngredientTag join Tag on tagId) on ingredientId) where ingredientId = :ingredientId")
    List<Tag> getTagNameByIngredient (@Bind("ingredientId") int ingredientId);

    @SqlQuery("select * from tag where tagId = :id")
    Tag findTagById(@Bind("id") int tagId);

    @SqlQuery("select * from tag where tagName = :name")
    Tag findTagByName(@Bind("name") String name);

    @GetGeneratedKeys
    @SqlUpdate("Insert into tag (tagName) values (:tagName)")
    int newTag(@Bind("tagName") String tagName);

    @SqlUpdate("delete from tag where tagId = :id")
    void deleteTagById(@Bind("id") int tagId);

    @SqlQuery("select t.* from Tag t, IngredientTag i where t.tagId=ingredient.tagId AND i.ingredientId=:ingredientId")
    List<Tag> getTagsByIngredientId(@Bind("ingredientId") int ingredientId);


    public void close();
}
