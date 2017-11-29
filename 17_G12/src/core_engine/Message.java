/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import java.io.Serializable;

/**
 *
 * @author BenPaxIndustries
 */
public class Message implements Serializable{
    private String description;
    private String oldMessage;
    
    public Message()
    {
        this.oldMessage = "";
        this.description = "";
    }

    public String getDescription() {
        String msgOut = "> " + description + "\n\n> " + oldMessage;
        
        oldMessage = description;
        description = "";
        return msgOut;
    }

    public void setDescription(String description) {
        this.description += description + "\n";
    }
    
}
