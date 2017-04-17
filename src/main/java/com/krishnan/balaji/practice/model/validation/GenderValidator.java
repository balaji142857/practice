package com.krishnan.balaji.practice.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {

	@Override
	public void initialize(Gender paramA) {
	}

	@Override
	public boolean isValid(String gender, ConstraintValidatorContext ctx) {
		if(gender == null){
			return false;
		}
		else if(gender.equalsIgnoreCase("male") || 
				gender.equalsIgnoreCase("female") ||
				gender.equalsIgnoreCase("neuter"))
			return true;
        else return false;
	}

}