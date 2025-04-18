package love.kill.demoformethodcachewithmemory.domain;

import java.io.Serializable;

/**
 * DemoDTO
 *
 * @author Lycop
 */
public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO{" +
				"code=" + code +
				", message='" + message + '\'' +
				'}';
	}
}
