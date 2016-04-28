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
package net.jkernelmachines.classifier;

import java.util.List;
import java.util.Map;

import net.jkernelmachines.kernel.Kernel;

/**
 * Interface for Multiple Kernel Classes. Provides useful methods for
 * retrieveing multiple kernels related information.
 * 
 * @author picard
 * 
 */
public interface MKL<T> {
	
	/**
	 * Adds a kernel to the MKL problem
	 * @param kernel the new kernel to add
	 */
	public void addKernel(Kernel<T> kernel);

	/**
	 * Gets an array containing the weights of the different kernels, in the
	 * same order as getKernels()
	 * 
	 * @return the array of weights
	 */
	public double[] getKernelWeights();

	/**
	 * Gets an array of the kernels in the set, in the same order as
	 * getKernelWeights()
	 * 
	 * @return the array of kernels
	 */
	public List<Kernel<T>> getKernels();

	/**
	 * Gets a mapping of pairs &lt;Kernel,Double&gt; containing the kernels and
	 * weights in the set.
	 * 
	 * @return the map of pairs &lt; kernel,weight &gt;
	 */
	public Map<Kernel<T>, Double> getKernelWeightMap();

}