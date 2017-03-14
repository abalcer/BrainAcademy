package com.brainacademy.gui.app.ui.forms;

import com.brainacademy.gui.app.model.Airline;
import com.brainacademy.gui.app.model.Airport;
import com.brainacademy.gui.app.model.Route;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RoutesTableModel
        extends AbstractTableModel {
    private List<Route> routes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return routes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "#";
            case 1:
                return "Airline";
            case 2:
                return "From";
            case 3:
                return "To";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (routes.size() <= rowIndex) {
            return null;
        }

        Route route = routes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return route.getId();
            case 1:
                Airline airline = route.getAirline();
                return airline != null ? airline.getName() : "<none>";
            case 2:
                Airport srcAirport = route.getSrcAirport();
                return srcAirport != null ? srcAirport.getName() : "<none>";
            case 3:
                Airport dstAirport = route.getDstAirport();
                return dstAirport != null ? dstAirport.getName() : "<none>";
            default:
                return null;
        }
    }

    public void setRoutes(Iterable<Route> routes) {
        this.routes.clear();
        routes.forEach(this.routes::add);
        fireTableDataChanged();
    }
}
