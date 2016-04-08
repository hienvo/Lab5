import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name = "Response")
public class ServerResponse {
		public String code;
//		public String message;
		public String id;
		public String message;
		
		@XmlElement
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		@XmlElement
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}


}
