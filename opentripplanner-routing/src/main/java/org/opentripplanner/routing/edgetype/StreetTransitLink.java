package org.opentripplanner.routing.edgetype;

import org.opentripplanner.routing.core.AbstractEdge;
import org.opentripplanner.routing.core.State;
import org.opentripplanner.routing.core.TransportationMode;
import org.opentripplanner.routing.core.TraverseOptions;
import org.opentripplanner.routing.core.TraverseResult;
import org.opentripplanner.routing.core.Vertex;

import com.vividsolutions.jts.geom.Geometry;

public class StreetTransitLink extends AbstractEdge {

    public StreetTransitLink(Vertex fromv, Vertex tov) {
        super(fromv, tov);
    }

    private static final long serialVersionUID = -3311099256178798981L;

    public String getDirection() {
        return null;
    }

    public double getDistance() {
        return 0;
    }

    public String getEnd() {
        // TODO Auto-generated method stub
        return null;
    }

    public Geometry getGeometry() {
        return null;
    }

    public TransportationMode getMode() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return "street transit link";
    }

    public String getStart() {
        // TODO Auto-generated method stub
        return null;
    }

    public TraverseResult traverse(State s0, TraverseOptions wo) {
        State s1 = s0.clone();
        return new TraverseResult(0, s1);
    }

    public TraverseResult traverseBack(State s0, TraverseOptions wo) {
        State s1 = s0.clone();
        return new TraverseResult(0, s1);
    }

}