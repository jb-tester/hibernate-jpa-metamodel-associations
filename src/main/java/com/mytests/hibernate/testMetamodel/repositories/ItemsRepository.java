package com.mytests.hibernate.testMetamodel.repositories;

import com.mytests.hibernate.testMetamodel.data.Items;
import org.hibernate.annotations.processing.Find;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/22/2024.</p>
 * <p>Project: hibernate-jpa-metamodel-associations</p>
 * *
 */
public interface ItemsRepository {

    @Find
    List<Items> findItemByCategory(String category);
}
