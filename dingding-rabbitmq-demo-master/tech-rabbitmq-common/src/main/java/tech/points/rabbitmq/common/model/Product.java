package tech.points.rabbitmq.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Company company;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", " + company + "]";
	}
}
