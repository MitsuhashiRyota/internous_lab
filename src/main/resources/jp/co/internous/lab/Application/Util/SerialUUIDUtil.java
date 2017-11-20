package jp.co.internous.lab.Application.Util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SerialUUIDUtil {

	private UUID serialUUID = UUID.randomUUID();

}
