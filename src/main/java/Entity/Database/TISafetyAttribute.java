package Entity.Database;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Atrybut")
public class TISafetyAttribute {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	
	
	
	
	

	public TISafetyAttribute(String name) {
		super();
		this.name = name;
	}

	public TISafetyAttribute() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	
	
	

	
	
}
