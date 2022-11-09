package ajc.sopra.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;

public enum Status {
	@JsonView(JsonViews.Common.class)
	 New, Reconditioned, Repaired;
}
