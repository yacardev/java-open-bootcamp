package com.bootcamp.bootcampfinal.Controllers;

import com.bootcamp.bootcampfinal.Entities.User;
import com.bootcamp.bootcampfinal.Services.UsersService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class UsersController {
    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    };

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
        return userService.usersList();
    }

    @GET
    @Path("/users/{nickname}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("nickname") String nickName){
        return userService.searchUser(nickName);
    }

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user){
        userService.createUser(user);
        return Response.created(URI.create("/users/"+user.nickName)).build();
    }

    @DELETE
    @Path("/users/{nickname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("nickname") String nickName){
        userService.deleteUser(nickName);
        return Response.ok().build();
    }

}
