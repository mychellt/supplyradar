package br.com.supplyradar.core.utils;


import br.com.supplyradar.domain.AbstractDomainObject;

import static java.util.Objects.nonNull;

public class CoreUtils {
	public static boolean isValid(AbstractDomainObject<?> entity) {
		return nonNull(entity) && nonNull(entity.getId());
	}
	public static boolean isNotValid(AbstractDomainObject<?> entity) {
		return !isValid(entity);
	}
}
