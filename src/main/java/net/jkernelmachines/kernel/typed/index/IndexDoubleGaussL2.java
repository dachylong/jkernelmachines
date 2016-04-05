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
package net.jkernelmachines.kernel.typed.index;

import net.jkernelmachines.kernel.GaussianKernel;

/**
 * Kernel on double[] that computes the L2 distance of a specified component j:
 * k(x, y) = (x[j]-y[j])*(x[j]-y[j])
 * @author dpicard
 *
 */
public class IndexDoubleGaussL2 extends GaussianKernel<double[]> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102467593724674738L;
	
	
	private double gamma = 0.1;
	private int ind = 0;
	
	/**
	 * Constructor specifying the component which is used
	 * @param feature the index of the component
	 */
	public IndexDoubleGaussL2(int feature)
	{
		ind = feature;
	}
	
	@Override
	public double valueOf(double[] t1, double[] t2) {
		if(t1[ind] == 0. && t2[ind] == 0.)
			return 1.;
		return Math.exp(-gamma * (t1[ind] - t2[ind])*(t1[ind] - t2[ind]));
	}

	@Override
	public double valueOf(double[] t1) {
		
		return 1.0;
	}

	public void setGamma(double g)
	{
		gamma = g;
	}
	
	public void setIndex(int i)
	{
		this.ind = i;
	}

	public double getGamma() {
		return gamma;
	}

	@Override
	public double distanceValueOf(double[] t1, double[] t2) {
		double v =t1[ind] - t2[ind]; 
		return v*v;
	}
}
