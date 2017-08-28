/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class InvalidUsernameException extends Exception{
    public InvalidUsernameException(String message){
        super(message);
    }
}
