package com.subex.ramasubramani;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounding
{
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		int roundingdp = 2;
		BigDecimal bigDecimal = new BigDecimal( 10.555 );
		System.out.println( bigDecimal );
		Float floatValue = bigDecimal.multiply( new BigDecimal( Math.pow( 10, roundingdp ) ) ).floatValue();
		BigDecimal modified = new BigDecimal( Math.round( floatValue ) / new Float( Math.pow( 10, roundingdp ) ) );
		System.out.println( modified );
		System.out.println( bigDecimal.setScale( roundingdp, RoundingMode.HALF_UP ) );
		
	}
}
