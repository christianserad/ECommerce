/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class LoginResult {
    private boolean usernameError;
    private boolean passwordError;
    private boolean nameError;
    private boolean lastNameError;
    private String usernameErrorMessage;
    private String passwordErrorMessage;
    private String nameErrorMessage;
    private String lastNameErrorMessage;

    public boolean isSuccess() {
        if(usernameError || passwordError || nameError || lastNameError){
            return false;
        }
        else{
            return true;
        }
    }

    public void setUsernameError(boolean usernameError) {
        this.usernameError = usernameError;
    }

    public void setPasswordError(boolean passwordError) {
        this.passwordError = passwordError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }

    public void setLastNameError(boolean lastNameError) {
        this.lastNameError = lastNameError;
    }
    
    public boolean isUsernameError() {
        return usernameError;
    }

    public boolean isPasswordError() {
        return passwordError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public boolean isLastNameError() {
        return lastNameError;
    }

    public String getUsernameErrorMessage() {
        return usernameErrorMessage;
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public String getNameErrorMessage() {
        return nameErrorMessage;
    }

    public String getLastNameErrorMessage() {
        return lastNameErrorMessage;
    }

    public void setUsernameErrorMessage(String usernameErrorMessage) {
        this.usernameErrorMessage = usernameErrorMessage;
    }

    public void setPasswordErrorMessage(String passwordErrorMessage) {
        this.passwordErrorMessage = passwordErrorMessage;
    }

    public void setNameErrorMessage(String nameErrorMessage) {
        this.nameErrorMessage = nameErrorMessage;
    }

    public void setLastNameErrorMessage(String lastNameErrorMessage) {
        this.lastNameErrorMessage = lastNameErrorMessage;
    }
    
    
}
