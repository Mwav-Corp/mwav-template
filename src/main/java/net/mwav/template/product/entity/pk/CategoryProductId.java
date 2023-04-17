package net.mwav.template.product.entity.pk;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CategoryProductId implements Serializable {

	private static final long serialVersionUID = -4884566291069405492L;

	private String category;

	private String product;

}
