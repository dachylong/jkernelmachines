/*******************************************************************************
 * Copyright (c) 2016, David Picard.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
package net.jkernelmachines.kernel.extra.bag;

import java.io.Serializable;
import java.util.List;

import net.jkernelmachines.kernel.Kernel;


/**
 * Default kernel on bags : sum all kernel values involving an element from B1 and an element from B2 between specified bounds.
 * the bound can be made different for left and right list, which doesn't lead to a kernel anymore.
 * However, this can be a usefull option to debug or view some precise elements of the sum.
 * @author dpicard
 *
 * @param <S> list type
 * @param <T> type of element in the bag
 */
public class SubListKernel2<S,T extends List<S>> extends Kernel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1591055803491554966L;
	
	private int fr1 = 0, fr2 = 0;
	private int to1 = 0, to2 = 0;
	private Kernel<S> kernel;
	private double eps = 10e-6;
	
	


	/**
	 * @param kernel kernel
	 * @param fr1 beginning bound for left list (inclusive)
	 * @param to1 end bound for left list (exclusive)
	 * @param fr2 beginning bound for right list (inclusive)
	 * @param to2 end bound for right list (exclusive)
	 */
	public SubListKernel2(Kernel<S> kernel, int fr1, int to1, int fr2, int to2) {
		this.kernel = kernel;
		this.fr1 = fr1;
		this.to1 = to1;
		this.fr2 = fr2;
		this.to2 = to2;
	}

	@Override
	public double valueOf(T t1, T t2) {
		double sum = 0;
		if(to1 > t1.size())
			to1 = t1.size();
		if(to2 > t2.size())
			to2 = t2.size();
		
		for(int i = fr1; i < to1; i++)
		for(int j = fr2; j < to2; j++)
		{
			double d = kernel.valueOf(t1.get(i), t2.get(j));
			if(d > eps)
				sum += d;
		}
		
		return sum/((double)((to1-fr1)*(to2-fr2)));
	}

	@Override
	public double valueOf(T t1) {
		return valueOf(t1, t1);
	}



	
	
}

	

