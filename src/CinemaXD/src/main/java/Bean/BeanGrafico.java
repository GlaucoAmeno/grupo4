package Bean;

import RecomendacaoFilmes.ConectaBanco;
import classes.Filmes;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

@ManagedBean
public class BeanGrafico implements Serializable {

    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private BarChartModel initBarModel() throws ClassNotFoundException, SQLException {
        BarChartModel model = new BarChartModel();

        ChartSeries filmes = new ChartSeries();
        filmes.setLabel("Filmes");

        List<Filmes> todos = new ArrayList<Filmes>();

        todos = ConectaBanco.listAll();
        for (int i = 0; i < todos.size(); i++) {

            String[] datalanc = todos.get(i).getDataLancamento().split("/");
            System.out.println(datalanc[0]);

            if (datalanc[2].equals("2016")) {
                filmes.set(todos.get(i).getNome(), ConectaBanco.getFilmesMaisAssistidos(todos.get(i)));
            }
        }

        //filmes.set("2011", 156);
        System.err.println("Passou");
        model.addSeries(filmes);

        return model;
    }

    private void createBarModels() {
        try {
            createBarModel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BeanGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createBarModel() throws ClassNotFoundException, SQLException {
        barModel = initBarModel();

        barModel.setTitle("Ranking de Vendas");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Filmes");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Vendas");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

}
