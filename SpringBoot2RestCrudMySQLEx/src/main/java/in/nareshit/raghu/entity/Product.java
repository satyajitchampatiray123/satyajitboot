package in.nareshit.raghu.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="prodtab")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer prodId;
	
	@Column(name="pcode")
	private String prodCode;
	
	@Column(name="pcost")
	private Double prodCost;
	
	@Column(name="pgst")
	private Double prodGst;
	
	@Column(name="pdisc")
	private Double prodDisc;
}
