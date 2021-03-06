package com.sandbox9.devicedetector;

import com.sandbox9.devicedetector.dto.Browser;
import com.sandbox9.devicedetector.dto.Device;
import com.sandbox9.devicedetector.dto.OS;
import com.sandbox9.devicedetector.dto.ReadableUserAgent;
import com.sandbox9.devicedetector.parser.browser.BrowserParser;
import com.sandbox9.devicedetector.parser.device.DeviceParser;
import com.sandbox9.devicedetector.parser.os.OSParser;

import javax.servlet.http.HttpServletRequest;

/**
 * 입력받은 String값을 기준으로 기기정보, 브라우저, OS등을 식별한 뒤
 * 결과를 ReadableUserAgent DTO로 반환한다.
 *
 * @author devSejong
 * @since 1.0
 */
public class UserAgentParser {
	private DeviceParser deviceParser;
	private OSParser osParser;
	private BrowserParser browserParser;

	public UserAgentParser() {
		deviceParser = new DeviceParser();
		osParser = new OSParser();
		browserParser = new BrowserParser();
	}

	/**
	 * user-agent 문자열을 기반으로 기기식별 정보를 반환한다.
	 *
	 * @param request
	 * @return
	 */
	public ReadableUserAgent parse(HttpServletRequest request) {
		String userAgentString = request.getHeader("User-Agent");
		OS os = osParser.parse(userAgentString);
		Browser browser = browserParser.parse(userAgentString);
		Device device = deviceParser.parse(request);


		return new ReadableUserAgent(os, device, browser, userAgentString);
	}
}
