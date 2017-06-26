package com.tum.fbl.core.persistence.category;

import com.tum.fbl.core.persistence.category.Category;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class CategoryMapper implements ResultSetMapper<Category> {

    @Override
    public Category map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Category(
                r.getInt("categoryId"),
                r.getString("categoryName"),
                r.getString("categoryDescription"));
    }

}