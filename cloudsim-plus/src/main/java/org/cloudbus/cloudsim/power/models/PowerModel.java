/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009-2012, The University of Melbourne, Australia
 */
package org.cloudbus.cloudsim.power.models;

import org.cloudbus.cloudsim.hosts.power.PowerHost;

/**
 * The PowerModel interface needs to be implemented in order to provide a model
 * of power consumption of hosts, depending on utilization of a critical system
 * component, such as CPU.
 * The interface implements the Null Object
 * Design Pattern in order to start avoiding {@link NullPointerException} when
 * using the {@link PowerModel#NULL} object instead of attributing {@code null} to
 * {@link PowerModel} variables.
 *
 * <p>If you are using any algorithms, policies or workload included in the
 * power package please cite the following paper:</p>
 *
 * <ul>
 * <li><a href="http://dx.doi.org/10.1002/cpe.1867">Anton Beloglazov, and
 * Rajkumar Buyya, "Optimal Online Deterministic Algorithms and Adaptive
 * Heuristics for Energy and Performance Efficient Dynamic Consolidation of
 * Virtual Machines in Cloud Data Centers", Concurrency and Computation:
 * Practice and Experience (CCPE), Volume 24, Issue 13, Pages: 1397-1420, John
 * Wiley & Sons, Ltd, New York, USA, 2012</a></li>
 * </ul>
 *
 * @author Anton Beloglazov
 *
 * @since CloudSim Toolkit 2.0
 */
public interface PowerModel {
    /**
     * A property that implements the Null Object Design Pattern for {@link PowerHost}
     * objects.
     */
    PowerModel NULL = new PowerModel() {
        @Override public PowerHost getHost() { return PowerHost.NULL; }
        @Override public void setHost(PowerHost host) {}
        @Override public double getPower(double utilization) throws IllegalArgumentException { return 0; }
    };

    PowerHost getHost();

    void setHost(PowerHost host);

    /**
     * Gets power consumption (in Watts/Second) of the Power Model, according to the utilization
     * percentage of a critical resource, such as CPU.
     *
     * @param utilization the utilization percentage (between [0 and 1]) of a
     * resource that is critical for power consumption.
     * @return the power consumption (in Watts/Second)
     * @throws IllegalArgumentException when the utilization percentage is not
     * between [0 and 1]
     */
    double getPower(double utilization) throws IllegalArgumentException;
}
