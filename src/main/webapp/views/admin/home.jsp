<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 10/28/2022
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/admin" var="URL"></c:url>

<!-- Content -->
<div class="container-xxl flex-grow-1 container-p-y">
    <div class="row">
<%--        <div class="col-lg-8 mb-4 order-0">--%>
<%--            <div class="card">--%>
<%--                <div class="d-flex align-items-end row">--%>
<%--                    <div class="col-sm-7">--%>
<%--                        <div class="card-body">--%>
<%--                            <h5 class="card-title text-primary">Congratulations John! 🎉</h5>--%>
<%--                            <p class="mb-4">--%>
<%--                                You have done <span class="fw-bold">72%</span> more sales today. Check your new--%>
<%--                                badge in--%>
<%--                                your profile.--%>
<%--                            </p>--%>

<%--                            <a href="javascript:;" class="btn btn-sm btn-outline-primary">View Badges</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="col-sm-5 text-center text-sm-left">--%>
<%--                        <div class="card-body pb-0 px-0 px-md-4">--%>
<%--                            <img--%>
<%--                                    src="${URL}/assets/img/illustrations/man-with-laptop-light.png"--%>
<%--                                    height="140"--%>
<%--                                    alt="View Badge User"--%>
<%--                                    data-app-dark-img="${URL}/illustrations/man-with-laptop-dark.png"--%>
<%--                                    data-app-light-img="${URL}/illustrations/man-with-laptop-light.png"--%>
<%--                            />--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-lg-4 col-md-4 order-1">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-6 col-md-12 col-6 mb-4">--%>
<%--                    <div class="card">--%>
<%--                        <div class="card-body">--%>
<%--                            <div class="card-title d-flex align-items-start justify-content-between">--%>
<%--                                <div class="avatar flex-shrink-0">--%>
<%--                                    <img--%>
<%--                                            src="${URL}/assets/img/icons/unicons/chart-success.png"--%>
<%--                                            alt="chart success"--%>
<%--                                            class="rounded"--%>
<%--                                    />--%>
<%--                                </div>--%>
<%--                                <div class="dropdown">--%>
<%--                                    <button--%>
<%--                                            class="btn p-0"--%>
<%--                                            type="button"--%>
<%--                                            id="cardOpt3"--%>
<%--                                            data-bs-toggle="dropdown"--%>
<%--                                            aria-haspopup="true"--%>
<%--                                            aria-expanded="false"--%>
<%--                                    >--%>
<%--                                        <i class="bx bx-dots-vertical-rounded"></i>--%>
<%--                                    </button>--%>
<%--                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="cardOpt3">--%>
<%--                                        <a class="dropdown-item" href="javascript:void(0);">View More</a>--%>
<%--                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <span class="fw-semibold d-block mb-1">Profit</span>--%>
<%--                            <h3 class="card-title mb-2">$12,628</h3>--%>
<%--                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>--%>
<%--                                +72.80%</small>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 col-md-12 col-6 mb-4">--%>
<%--                    <div class="card">--%>
<%--                        <div class="card-body">--%>
<%--                            <div class="card-title d-flex align-items-start justify-content-between">--%>
<%--                                <div class="avatar flex-shrink-0">--%>
<%--                                    <img--%>
<%--                                            src="${URL}/assets/img/icons/unicons/wallet-info.png"--%>
<%--                                            alt="Credit Card"--%>
<%--                                            class="rounded"--%>
<%--                                    />--%>
<%--                                </div>--%>
<%--                                <div class="dropdown">--%>
<%--                                    <button--%>
<%--                                            class="btn p-0"--%>
<%--                                            type="button"--%>
<%--                                            id="cardOpt6"--%>
<%--                                            data-bs-toggle="dropdown"--%>
<%--                                            aria-haspopup="true"--%>
<%--                                            aria-expanded="false"--%>
<%--                                    >--%>
<%--                                        <i class="bx bx-dots-vertical-rounded"></i>--%>
<%--                                    </button>--%>
<%--                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="cardOpt6">--%>
<%--                                        <a class="dropdown-item" href="javascript:void(0);">View More</a>--%>
<%--                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <span>Sales</span>--%>
<%--                            <h3 class="card-title text-nowrap mb-1">$4,679</h3>--%>
<%--                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>--%>
<%--                                +28.42%</small>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <!-- Total Revenue -->
        <div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4">
            <div class="card">
                <div class="row row-bordered g-0">
                    <div class="col-md-8">
                        <h5 class="card-header m-0 me-2 pb-3">Tổng doanh thu</h5>
                        <div id="totalRevenueChart" class="px-2"></div>
                    </div>
                    <div class="col-md-4">
                        <div class="card-body">
                            <div class="text-center">
                                <div class="dropdown">
                                    <button
                                            class="btn btn-sm btn-outline-primary dropdown-toggle"
                                            type="button"
                                            id="growthReportId"
                                            data-bs-toggle="dropdown"
                                            aria-haspopup="true"
                                            aria-expanded="false"
                                    >
                                        ${sellYear}
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="growthReportId">
                                        <a class="dropdown-item" href="home?sellYear=2022">2022</a>
                                        <a class="dropdown-item" href="home?sellYear=2021">2021</a>
                                        <a class="dropdown-item" href="home?sellYear=2019">2019</a>
                                    </div>
                                </div>
                            </div>
                        </div>
<%--                        <div id="growthChart"></div>--%>
                        <div class="text-center fw-semibold pt-3 mb-2">Doanh thu Theo Năm</div>

                        <div class="d-flex px-xxl-4 px-lg-2 p-4 gap-xxl-3 gap-lg-1 gap-3 justify-content-between">
                            <div class="d-flex">
                                <div class="me-2">
                                        <span class="badge bg-label-primary p-2"><i
                                                class="bx bx-dollar text-primary"></i></span>
                                </div>
                                <div class="d-flex flex-column">
                                    <small>${sellYear}</small>
                                    <h6 class="mb-0">${countSumSell} VND</h6>
                                </div>
                            </div>
                            <div class="d-flex">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/ Total Revenue -->
        <div class="col-12 col-md-8 col-lg-4 order-3 order-md-2">
            <div class="row">
                <div class="col-6 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                                <div class="avatar flex-shrink-0">
                                    <img src="${URL}/assets/img/icons/unicons/paypal.png" alt="Credit Card"
                                         class="rounded"/>
                                </div>
                                <div class="dropdown">
                                    <button
                                            class="btn p-0"
                                            type="button"
                                            id="cardOpt4"
                                            data-bs-toggle="dropdown"
                                            aria-haspopup="true"
                                            aria-expanded="false"
                                    >
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="cardOpt4">
                                        <a class="dropdown-item" href="javascript:void(0);">View More</a>
                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                    </div>
                                </div>
                            </div>
                            <span class="d-block mb-1">Payments</span>
                            <h3 class="card-title text-nowrap mb-2">$2,456</h3>
                            <small class="text-danger fw-semibold"><i class="bx bx-down-arrow-alt"></i>
                                -14.82%</small>
                        </div>
                    </div>
                </div>
                <div class="col-6 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                                <div class="avatar flex-shrink-0">
                                    <img src="${URL}/assets/img/icons/unicons/cc-primary.png" alt="Credit Card"
                                         class="rounded"/>
                                </div>
                                <div class="dropdown">
                                    <button
                                            class="btn p-0"
                                            type="button"
                                            id="cardOpt1"
                                            data-bs-toggle="dropdown"
                                            aria-haspopup="true"
                                            aria-expanded="false"
                                    >
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="cardOpt1">
                                        <a class="dropdown-item" href="javascript:void(0);">View More</a>
                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                    </div>
                                </div>
                            </div>
                            <span class="fw-semibold d-block mb-1">Giao Dịch(vnd)</span>
                            <h3 class="card-title mb-2">${transaction}</h3>
                            <c:if test="${transactionPercent > 0}">
                                <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>
                                    +${transactionPercent}%</small>
                            </c:if>
                            <c:if test="${transactionPercent < 0}">
                                <small class="text-danger fw-semibold"><i class="bx bx-down-arrow-alt"></i>
                                    -${transactionPercent}%</small>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
<%--            <div class="row"> ---%>
<%--                <div class="col-12 mb-4">--%>
<%--                    <div class="card">--%>
<%--                        <div class="card-body">--%>
<%--                            <div class="d-flex justify-content-between flex-sm-row flex-column gap-3">--%>
<%--                                <div class="d-flex flex-sm-column flex-row align-items-start justify-content-between">--%>
<%--                                    <div class="card-title">--%>
<%--                                        <h5 class="text-nowrap mb-2">Profile Report</h5>--%>
<%--                                        <span class="badge bg-label-warning rounded-pill">Year 2021</span>--%>
<%--                                    </div>--%>
<%--                                    <div class="mt-sm-auto">--%>
<%--                                        <small class="text-success text-nowrap fw-semibold"--%>
<%--                                        ><i class="bx bx-chevron-up"></i> 68.2%</small--%>
<%--                                        >--%>
<%--                                        <h3 class="mb-0">$84,686k</h3>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div id="profileReportChart"></div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </div>
    <div class="row">
        <!-- Order Statistics -->
        <div class="col-md-6 col-lg-4 col-xl-4 order-0 mb-4">
            <div class="card h-100">
                <div class="card-header d-flex align-items-center justify-content-between pb-0">
                    <div class="card-title mb-0">
                        <h5 class="m-0 me-2">Đơn Đăt Hàng</h5>
                        <%--                        <small class="text-muted">42.82k Total Sales</small>--%>
                    </div>
                    <div class="dropdown">
                        <button
                                class="btn p-0"
                                type="button"
                                id="orederStatistics"
                                data-bs-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                        >
                            <i class="bx bx-dots-vertical-rounded"></i>
                        </button>
                        <div class="dropdown-menu dropdown-menu-end" aria-labelledby="orederStatistics">
                            <a class="dropdown-item" href="javascript:void(0);">Select All</a>
                            <a class="dropdown-item" href="javascript:void(0);">Refresh</a>
                            <a class="dropdown-item" href="javascript:void(0);">Share</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <div class="dropdown">
                            <button
                                    class="btn btn-sm btn-outline-primary dropdown-toggle"
                                    type="button"
                                    id="growthReportId"
                                    data-bs-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                            >
                                ${orderYear}
                            </button>
                            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="growthReportId">
                                <a class="dropdown-item" href="home?orderYear=2022">2022</a>
                                <a class="dropdown-item" href="home?orderYear=2021">2021</a>
                                <a class="dropdown-item" href="home?orderYear=2019">2019</a>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex flex-column align-items-center gap-1">
                        <h2 class="mb-2">${countOrder}</h2>
                        <span>Tổng Số Đơn Đặt Hàng</span>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-6 col-lg-4 order-1 mb-4">
            <div class="card h-100">
<%--                <div class="card-header">--%>
<%--                    <ul class="nav nav-pills" role="tablist">--%>
<%--                        <li class="nav-item">--%>
<%--                            <button--%>
<%--                                    type="button"--%>
<%--                                    class="nav-link active"--%>
<%--                                    role="tab"--%>
<%--                                    data-bs-toggle="tab"--%>
<%--                                    data-bs-target="#navs-tabs-line-card-income"--%>
<%--                                    aria-controls="navs-tabs-line-card-income"--%>
<%--                                    aria-selected="true"--%>
<%--                            >--%>
<%--                                Income--%>
<%--                            </button>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <button type="button" class="nav-link" role="tab">Expenses</button>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <button type="button" class="nav-link" role="tab">Profit</button>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--                <div class="card-body px-0">--%>
<%--                    <div class="tab-content p-0">--%>
<%--                        <div class="tab-pane fade show active" id="navs-tabs-line-card-income" role="tabpanel">--%>
<%--                            <div class="d-flex p-4 pt-3">--%>
<%--                                <div class="avatar flex-shrink-0 me-3">--%>
<%--                                    <img src="${URL}/assets/img/icons/unicons/wallet.png" alt="User"/>--%>
<%--                                </div>--%>
<%--                                <div>--%>
<%--                                    <small class="text-muted d-block">Total Balance</small>--%>
<%--                                    <div class="d-flex align-items-center">--%>
<%--                                        <h6 class="mb-0 me-1">$459.10</h6>--%>
<%--                                        <small class="text-success fw-semibold">--%>
<%--                                            <i class="bx bx-chevron-up"></i>--%>
<%--                                            42.9%--%>
<%--                                        </small>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div id="incomeChart"></div>--%>
<%--                            <div class="d-flex justify-content-center pt-4 gap-2">--%>
<%--                                <div class="flex-shrink-0">--%>
<%--                                    <div id="expensesOfWeek"></div>--%>
<%--                                </div>--%>
<%--                                <div>--%>
<%--                                    <p class="mb-n1 mt-1">Expenses This Week</p>--%>
<%--                                    <small class="text-muted">$39 less than last week</small>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
        <div class="col-md-6 col-lg-4 order-2 mb-4">
            <div class="card h-100">
                <div class="card-header d-flex align-items-center justify-content-between">
                    <h5 class="card-title m-0 me-2">Người Dùng Mới</h5>
                    <div class="dropdown">
                        <button
                                class="btn p-0"
                                type="button"
                                id="transactionID"
                                data-bs-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                        >
                            <i class="bx bx-dots-vertical-rounded"></i>
                        </button>
                        <div class="dropdown-menu dropdown-menu-end" aria-labelledby="transactionID">
                            <a class="dropdown-item" href="javascript:void(0);">Last 28 Days</a>
                            <a class="dropdown-item" href="javascript:void(0);">Last Month</a>
                            <a class="dropdown-item" href="javascript:void(0);">Last Year</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <ul class="p-0 m-0">
                        <li class="d-flex mb-4 pb-1">
                            <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
                                <div class="me-2">
                                    <small class="text-muted d-block mb-1"></small>
                                    <h6 class="mb-0">Tên</h6>
                                </div>
                                <div class="user-progress d-flex align-items-center gap-1">
                                    <h6 class="mb-0">Ví</h6>
                                    <span class="text-muted">(VND)</span>
                                </div>
                            </div>
                        </li>
                        <c:forEach items="${userNew}" var="kq">
                            <li class="d-flex mb-4 pb-1">
                                <div class="avatar flex-shrink-0 me-3">
                                    <c:url value="/image?fname=user/${kq.avatar}"
                                              var="imgUrl"></c:url>
                                    <img src="${imgUrl}"
                                         class="rounded float-start" height="40" width="40"
                                         alt="...">
                                </div>
                                <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
                                    <div class="me-2">
                                        <small class="text-muted d-block mb-1"></small>
                                        <h6 class="mb-0">${kq.firstName}<span> </span>${kq.lastName}</h6>
                                    </div>
                                    <div class="user-progress d-flex align-items-center gap-1">
                                        <h6 class="mb-0">${kq.e_wallet}</h6>
                                        <span class="text-muted">VND</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>


                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--/ Order Statistics -->

    <!-- Expense Overview -->

    <!--/ Expense Overview -->

    <!-- Transactions -->

    <!--/ Transactions -->
</div>

</div>
<!-- / Content -->
