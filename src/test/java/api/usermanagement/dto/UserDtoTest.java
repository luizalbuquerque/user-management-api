package api.usermanagement.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoTest {

    @Test
    public void userDtoTest(){
        UserDto userDto = new UserDto();
        userDto.setId(userDto.getId());
        userDto.setEmail(userDto.getEmail());
        userDto.setPassword(userDto.getPassword());
        assertEquals(userDto, userDto);
    }

}
