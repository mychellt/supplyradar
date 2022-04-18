package br.com.supplyradar.persistence.utils;


import br.com.supplyradar.persistence.model.AbstractEntity;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class EntityUtils {
	public static boolean isValid(AbstractEntity<?> entity) {
		return nonNull(entity) && nonNull(entity.getId());
	}
	public static boolean isNotValid(AbstractEntity<?> entity) {
		return !isValid(entity);
	}
}
