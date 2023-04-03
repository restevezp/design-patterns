package com.kreitek.pets.controllers;

import com.kreitek.pets.utils.ConsoleLogger;
import com.kreitek.pets.Controller;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class CatController implements Controller {

    // TODO Logger declaration
    static ConsoleLogger consoleLogger = ConsoleLogger.getInstance();


    @Override
    public String executePut(String petName, String ownerName, String telephone) {
        // TODO logger.debug("CatController.executePut " + petName + "," + ownerName + "," + telephone);
        consoleLogger.debug("CatController.executePut " + petName + "," + ownerName + "," + telephone);

        Cat cat = new Cat(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewCat(cat);
        return "New cat has been added";
    }

    @Override
    public String executeGet() {
        // TODO logger.debug("CatController.executeGet CATS");
        consoleLogger.debug("CatController.executeGet CATS");

        DbService dbService = DbService.getInstance();
        List<Cat> cats = dbService.getCats();
        String response = "";
        for (Cat cat:cats) {
            response += cat.toString() + "\r\n";
        }
        return response;
    }
}
