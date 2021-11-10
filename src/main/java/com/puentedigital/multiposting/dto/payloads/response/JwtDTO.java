package com.puentedigital.multiposting.dto.payloads.response;

import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class JwtDTO {

	@NonNull
	private String token;

	private String type = "Bearer";

	@NonNull
	private Long id;

	@NonNull
	private String username;

	@NonNull
	private String email;

	@NonNull
	private List<String> roles;

	@NonNull
	private Boolean defaultPassword;
}
