package love.kill.demoformethodcachewithmemory.domain;

import java.io.Serializable;

/**
 * DemoDTO
 *
 * @author Lycop
 */
public class DemoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String key;
	private String val;
	private String response;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "DemoDTO{" +
				"key='" + key + '\'' +
				", val='" + val + '\'' +
				", response='" + response + '\'' +
				'}';
	}
}
