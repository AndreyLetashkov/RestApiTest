package adapters;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import models.*;
import utils.Parser;
import java.util.Collection;
import java.util.List;

public class Api extends ApiUtils {
    private final String postsUrl = Parser.parse("postsUrl");
    private final String usersUrl = Parser.parse("usersUrl");

    public Person postPerson(Person person, String headerKey, String headerValue) {
        return new Gson().fromJson(
                new ApiUtils().post(
                headerKey,
                headerValue,
                new Gson().toJson(person),
                postsUrl), Person.class);
    }

    public User getUser(int id) {
        return new Gson().fromJson(
                get(postsUrl + id), User.class);
    }

    public List<UserId> getUserIdList() {
        return new Gson().fromJson(
                get(postsUrl),
                new TypeToken<Collection<UserId>>() {}.getType()
        );
    }

    public List<DifficultUser> getDifficultUserList() {
        return new Gson().fromJson(
                get(usersUrl),
                new TypeToken<Collection<DifficultUser>>() {}.getType()
        );
    }

    public DifficultUser getDifficultUser(int id) {
        return new Gson().fromJson(
                get(usersUrl + id), DifficultUser.class
        );
    }
}