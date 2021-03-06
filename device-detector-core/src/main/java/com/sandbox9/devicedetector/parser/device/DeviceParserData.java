package com.sandbox9.devicedetector.parser.device;

import com.sandbox9.devicedetector.type.BaseDeviceType;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 디바이스 이름 패턴 타입이 담긴 DTO
 * @author devSejong
 * @since 1.0
 */
public class DeviceParserData {
	private String deviceName;
	private BaseDeviceType deviceType;
	private Pattern[] patterns;

	public DeviceParserData(String deviceName, BaseDeviceType deviceType, String[] patterns) {
		this.deviceName = deviceName;
		this.deviceType = deviceType;

		Pattern[] internalPatterns = new Pattern[patterns.length];
		for (int i = 0; i < patterns.length; i++)
			internalPatterns[i] = Pattern.compile(patterns[i], Pattern.CASE_INSENSITIVE);

		this.patterns = internalPatterns;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public BaseDeviceType getDeviceType() {
		return deviceType;
	}

	public Pattern[] getPatterns() {
		return patterns;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DeviceParserData{");
		sb.append("deviceName='").append(deviceName).append('\'');
		sb.append(", deviceType=").append(deviceType);
		sb.append(", patterns=").append(Arrays.toString(patterns));
		sb.append('}');
		return sb.toString();
	}
}
