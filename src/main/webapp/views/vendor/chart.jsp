<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div style="display: flex;">
	<div style="width: 70%; ">
		<div class="alert alert-primary" role="alert">
			<h3>Hiện tại của hàng có ${countAllProduct} sản phẩm</h3>
		</div>
		<div class="alert alert-success" role="alert">
			<h3>Hiện tại của hàng có ${countAllOrder} đơn đặt hàng</h3>
		</div>
	</div>
	<div class="card"
		style="width: 18rem; box-shadow: 5px 5px 6px 5px rgb(67 89 113/ 15%); margin: 15px 30px;">
		<h5 style="text-align: center;">Top sản phẩm bán chạy nhất</h5>
		<core:url value="/image?fname=product/${top1sold.listImages}"
			var="imgUrl"></core:url>
		<img class="card-img-top" height="200" width="200" id="image"
			width="100px" src="${imgUrl}" alt="Images">
		<div class="card-body" style="text-align: center;">
			<h5 class="card-title">${top1sold.name}</h5>
			<p class="card-text">${top1sold.description}</p>
		</div>
	</div>
</div>
<div style="display: flex; margin: 30px 0;">
	<canvas id="lineChart" style="width: 33%; max-width: 400px"></canvas>
	<canvas id="colChart" style="width: 33%; max-width: 400px"></canvas>
	<canvas id="circleChart" style="width: 33%; max-width: 400px"></canvas>
</div>
<div style="display: flex;  margin: 30px 0;">
	<canvas id="TotalLineChart" style="width: 33%; max-width: 400px"></canvas>
	<canvas id="TotalcolChart" style="width: 33%; max-width: 400px"></canvas>
	<canvas id="TotalcircleChart" style="width: 33%; max-width: 400px"></canvas>
</div>
<div style="display: flex;  margin: 30px 0;">
	<canvas id="OrderLineChart" style="width: 33%; max-width: 400px"></canvas>
	<canvas id="OrdercolChart" style="width: 33%; max-width: 400px"></canvas>
	<canvas id="OrdercircleChart" style="width: 33%; max-width: 400px"></canvas>
</div>
<script>
  var xValues = ${listDate};
  var yValues = ${listCount};
  new Chart("lineChart", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        fill: false,
        lineTension: 0,
        backgroundColor: "rgba(0,0,255,1.0)",
        borderColor: "blue",
        data: yValues
      }]
    },
    options: {
      legend: {display: false},
      scales: {
        yAxes: [{ticks: {min: 0, max:${maxcount}}}],
      },
        title: {
            display: true,
            text: "Số lượng sản phẩm được thêm trong 7 ngày gần nhất"
        }
    }
  });
  new Chart("colChart", {
      type: "bar",
      data: {
          labels: xValues,
          datasets: [{
              backgroundColor: ["blue", "blue","blue","blue","blue","blue","blue"],
              data: yValues
          }]
      },
      options: {
          legend: {display: false},
          title: {
              display: true,
              text: "Số lượng sản phẩm được thêm trong 7 ngày gần nhất"
          }
      }
  });
  new Chart("circleChart", {
      type: "pie",
      data: {
          labels: xValues,
          datasets: [{
              backgroundColor: [
                  "#b91d47",
                  "#00aba9",
                  "#2b5797",
                  "#e8c3b9",
                  "#1e7145",
                  "#red",
                  "#blue"
              ],
              data: yValues
          }]
      },
      options: {
          title: {
              display: true,
              text: "Số lượng sản phẩm được thêm trong 7 ngày gần nhất"
          }
      }
  });
  new Chart("TotalLineChart", {
	    type: "line",
	    data: {
	      labels: xValues,
	      datasets: [{
	        fill: false,
	        lineTension: 0,
	        backgroundColor: "rgba(0,0,255,1.0)",
	        borderColor: "blue",
	        data: ${listAmount}
	      }]
	    },
	    options: {
	      legend: {display: false},
	      scales: {
	        yAxes: [{ticks: {min: 0, max:${maxTotal}}}],
	      },
	        title: {
	            display: true,
	            text: "Thống kê doanh thu trong 7 ngày gần nhất"
	        }
	    }
	  });
  new Chart("TotalcolChart", {
      type: "bar",
      data: {
          labels: xValues,
          datasets: [{
              backgroundColor: ["blue", "blue","blue","blue","blue","blue","blue"],
              data: ${listAmount}
          }]
      },
      options: {
          legend: {display: false},
          title: {
              display: true,
              text: "Thống kê doanh thu trong 7 ngày gần nhất"
          }
      }
  });
  new Chart("TotalcircleChart", {
      type: "pie",
      data: {
          labels: xValues,
          datasets: [{
              backgroundColor: [
                  "#b91d47",
                  "#00aba9",
                  "#2b5797",
                  "#e8c3b9",
                  "#1e7145",
                  "#red",
                  "#blue"
              ],
              data: ${listAmount}
          }]
      },
      options: {
          title: {
              display: true,
              text: "Thống kê doanh thu trong 7 ngày gần nhất"
          }
      }
  });
  new Chart("OrderLineChart", {
	    type: "line",
	    data: {
	      labels: xValues,
	      datasets: [{
	        fill: false,
	        lineTension: 0,
	        backgroundColor: "rgba(0,0,255,1.0)",
	        borderColor: "blue",
	        data: ${listCountOrder}
	      }]
	    },
	    options: {
	      legend: {display: false},
	      scales: {
	        yAxes: [{ticks: {min: 0, max:${maxOrder}}}],
	      },
	        title: {
	            display: true,
	            text: "Thống kê số lượng order trong 7 ngày gần nhất"
	        }
	    }
	  });
new Chart("OrdercolChart", {
    type: "bar",
    data: {
        labels: xValues,
        datasets: [{
            backgroundColor: ["blue", "blue","blue","blue","blue","blue","blue"],
            data: ${listCountOrder}
        }]
    },
    options: {
        legend: {display: false},
        title: {
            display: true,
            text: "Thống kê số lượng order trong 7 ngày gần nhất"
        }
    }
});
new Chart("OrdercircleChart", {
    type: "pie",
    data: {
        labels: xValues,
        datasets: [{
            backgroundColor: [
                "#b91d47",
                "#00aba9",
                "#2b5797",
                "#e8c3b9",
                "#1e7145",
                "#red",
                "#blue"
            ],
            data: ${listCountOrder}
        }]
    },
    options: {
        title: {
            display: true,
            text: "Thống kê số lượng order trong 7 ngày gần nhất"
        }
    }
});
</script>
s
