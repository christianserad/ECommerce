package Controllers;

import Exceptions.InvalidPasswordException;
import Exceptions.InvalidUsernameException;
import java.util.ArrayList;

/**
 *
 * @author Christian Romar Paul Serad
 */
public class UserContainer {

    private ArrayList<User> user = new ArrayList<User>();

    public void generate() {
        user.add(new User("christian123", "hey", "christian", "serad"));
        user.add(new User("romar123", "hey", "romar", "serad"));
        user.add(new User("paul123", "hey", "paul", "serad"));
        user.add(new User("antor123", "hey", "antor", "serad"));
        user.add(new User("serad123", "hey", "serad", "serad"));
    }

    public User getUser(String username, String password) {
        User user = null;
        for (int i = 0; i < this.user.size(); i++) {
            if (this.user.get(i).getUsername().equals(username) && this.user.get(i).getPassword().equals(password)) {
                user = this.user.get(i);
                break;
            }
        }
        return user;
    }

    public LoginResult addUser(String username, String password, String name, String lastName) {
        LoginResult result = validate(username, password, name, lastName);
        if (result.isSuccess()) {
            user.add(new User(username, password, name, lastName));
            return result;
        } else {
            return result;
        }

    }

    private LoginResult validate(String username, String password, String name, String lastName) {
        LoginResult result = new LoginResult();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUsername().equals(username) && !result.isUsernameError()) {
                result.setUsernameError(true);
                result.setUsernameErrorMessage("Username already exist");
            }
            if (user.get(i).getPassword().equals(password) && !result.isPasswordError()) {
                result.setPasswordError(true);
                result.setPasswordErrorMessage("Password already exist");
            }
            if (user.get(i).getName().equals(name) && !result.isNameError()) {
                result.setNameError(true);
                result.setNameErrorMessage("Name already exist");
            }
            if (user.get(i).getLastName().equals(lastName) && !result.isLastNameError()) {
                result.setLastNameError(true);
                result.setLastNameErrorMessage("LastName already exist");
            }
        }

        try {
            if(!result.isUsernameError()){
                usernameValidate(username);
            }  
        }
        catch(InvalidUsernameException e){
            result.setUsernameError(true);
            result.setUsernameErrorMessage(e.getMessage());
        }
        
        try{
            if(!result.isPasswordError()){
                passwordValidate(password);
            }
            
        }
        catch(InvalidPasswordException e){
            result.setPasswordError(true);
            result.setPasswordErrorMessage(e.getMessage());
        }
        
        return result;
    }

    private void usernameValidate(String username) throws InvalidUsernameException {
        if (username.length() > 3) {
            int number = 0;
            int letter = 0;
            for (int i = 0; i < username.length(); i++) {
                if (Character.isDigit(username.charAt(i))) {
                    number += 1;
                } else if (Character.isLetter(username.charAt(i))) {
                    letter += 1;
                }
            }
            if(number == 0 || letter == 0){
                throw new InvalidUsernameException("Username must have at least a letter and a digit");
            }
        } else {
            throw new InvalidUsernameException("Username must be at least 4 characters");
        }
    }

    private void passwordValidate(String password) throws InvalidPasswordException {
        if (password.length() > 6) {
            int number = 0;
            int letter = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    number += 1;
                } else if (Character.isLetter(password.charAt(i))) {
                    letter += 1;
                }
            }
            if(number == 0 || letter == 0){
                throw new InvalidPasswordException("Password must have at least a letter and a digit");
            }
        } else {
            throw new InvalidPasswordException("Password must be at least 7 characters");
        }
    }

}
