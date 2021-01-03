package softuni.productshop.domain.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import softuni.productshop.domain.entities.Product;
import softuni.productshop.domain.entities.User;

import java.util.Set;

public class UsersAndProductsExportDto {

    @Expose
    private int usersCount;
    @Expose
    private UserExportDto users;


    public UsersAndProductsExportDto() {
    }

    public UserExportDto getUsers() {
        return users;
    }

    public void setUsers(UserExportDto users) {
        this.users = users;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }


}
