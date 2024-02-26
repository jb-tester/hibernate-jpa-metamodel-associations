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

    @Find
    List<Items> findItemByPrice(Integer price); // Integer instead of int: error should be reported

    @Find
    List<Items> findItemByPricePrimitiveType(int price); // int instead of Integer: no problems


}
