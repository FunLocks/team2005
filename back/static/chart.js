
        window.onload = function () {
            drawCharts();
            // グラフ描画
            $('#redraw').on('click', function () {
                drawCharts();
            });
        }

        

        function drawCharts(jsondata) { 

            am4core.useTheme(am4themes_animated);

            // Create chart instance
            var chart = am4core.create("chartdiv",am4charts.XYChart);

            var data = jsondata;
            var visits = 100;
            for (var i = 0; i < 6; i++) {
                visits += Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10);
                data.push({ date: data[i], value: visits });
            }

            chart.data = data;

            var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
            categoryAxis.renderer.grid.template.location = 0;
            categoryAxis.dataFields.category = "date";

            var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
            valueAxis.tooltip.disabled = true;

            var series = chart.series.push(new am4charts.ColumnSeries());
            series.dataFields.categoryX = "date";
            series.dataFields.valueY = "value";
            series.tooltipText = "{valueY.value}";
            series.tooltip.pointerOrientation = "horizontal";
            series.columns.template.width = 0.01;

            var bullet = series.bullets.create(am4charts.CircleBullet);

            chart.cursor = new am4charts.XYCursor();

            chart.scrollbarX = new am4core.Scrollbar();
            chart.scrollbarY = new am4core.Scrollbar();


            /*
            var series = chart.series.push(new am4plugins_timeline.CurveStepLineSeries());
            series.fillOpacity = 0.3;
            series.dataFields.dateX = "date";
            series.dataFields.valueY = "value";
            series.tooltipText = "{valueY}";
            series.tooltip.pointerOrientation = "vertical";
            series.tooltip.background.fillOpacity = 0.7;
            series.fill = chart.colors.getIndex(3);
            series.strokeWidth = 2;
            */

            
            //#chart.cursor = new am4charts.XYCursor();
            //#chart.cursor.xAxis = dateAxis;
            //#chart.cursor.yAxis = valueAxis;
            //#chart.cursor.lineY.disabled = true;
            
        }