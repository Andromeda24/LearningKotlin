package com.bright.userprofilems.mapper;

import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.dto.response.ProfileResponseDto;
import com.bright.userprofilems.dto.response.UserResponseDto;
import com.bright.userprofilems.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-12T20:25:20-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public User userRequestDtoToUser(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setProfile( profileMapper.profileRequestDtoToProfile( userRequestDto.profileRequestDto() ) );
        user.setUsername( userRequestDto.username() );
        user.setPassword( userRequestDto.password() );

        return user;
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        ProfileResponseDto profileResponseDto = null;
        String username = null;

        profileResponseDto = profileMapper.profileToProfileResponseDto( user.getProfile() );
        username = user.getUsername();

        UserResponseDto userResponseDto = new UserResponseDto( username, profileResponseDto );

        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> userToUserResponseDto(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( user.size() );
        for ( User user1 : user ) {
            list.add( userToUserResponseDto( user1 ) );
        }

        return list;
    }
}
