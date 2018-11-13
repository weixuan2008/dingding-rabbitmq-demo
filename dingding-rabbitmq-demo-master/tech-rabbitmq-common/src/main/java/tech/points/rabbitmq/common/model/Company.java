package tech.points.rabbitmq.common.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @description TODO
 * @author Eddie.Wei
 * @github: https://github.com/weixuan2008
 * @creatTime 2018-11-10
 */
@Getter
@Setter
public class Company extends Base {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
}
