package com.bright.userprofilems.mapper;

import com.bright.userprofilems.dto.request.ProfileRequestDto;
import com.bright.userprofilems.dto.response.ProfileResponseDto;
import com.bright.userprofilems.model.Profile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-12T20:25:20-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile profileRequestDtoToProfile(ProfileRequestDto profileRequestDto) {
        if ( profileRequestDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setFirstName( profileRequestDto.firstName() );
        profile.setLastName( profileRequestDto.lastName() );
        profile.setDateOfBirth( profileRequestDto.dateOfBirth() );
        profile.setEmail( profileRequestDto.email() );
        profile.setPhoneNumber( profileRequestDto.phoneNumber() );
        profile.setBio( profileRequestDto.bio() );

        return profile;
    }

    @Override
    public ProfileResponseDto profileToProfileResponseDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        String bio = null;

        firstName = profile.getFirstName();
        lastName = profile.getLastName();
        bio = profile.getBio();

        ProfileResponseDto profileResponseDto = new ProfileResponseDto( firstName, lastName, bio );

        return profileResponseDto;
    }
}
