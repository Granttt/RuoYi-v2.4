﻿/*!
 * Datetimepicker for Bootstrap
 *
 * Copyright 2012 Stefan Petre
 * Improvements by Andrew Rowls
 * Licensed under the Apache License v2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */
.datetimepicker {
	padding: 4px;
	margin-top: 1px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	direction: ltr;
}

.datetimepicker-inline {
	width: 220px;
}

.datetimepicker.datetimepicker-rtl {
	direction: rtl;
}

.datetimepicker.datetimepicker-rtl table tr td span {
	float: right;
}

.datetimepicker-dropdown, .datetimepicker-dropdown-left {
	top: 0;
	left: 0;
}

[class*=" datetimepicker-dropdown"]:before {
	content: '';
	display: inline-block;
	border-left: 7px solid transparent;
	border-right: 7px solid transparent;
	border-bottom: 7px solid #cccccc;
	border-bottom-color: rgba(0, 0, 0, 0.2);
	position: absolute;
}

[class*=" datetimepicker-dropdown"]:after {
	content: '';
	display: inline-block;
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-bottom: 6px solid #ffffff;
	position: absolute;
}

[class*=" datetimepicker-dropdown-top"]:before {
	content: '';
	display: inline-block;
	border-left: 7px solid transparent;
	border-right: 7px solid transparent;
	border-top: 7px solid #cccccc;
	border-top-color: rgba(0, 0, 0, 0.2);
	border-bottom: 0;
}

[class*=" datetimepicker-dropdown-top"]:after {
	content: '';
	display: inline-block;
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-top: 6px solid #ffffff;
	border-bottom: 0;
}

.datetimepicker-dropdown-bottom-left:before {
	top: -7px;
	right: 6px;
}

.datetimepicker-dropdown-bottom-left:after {
	top: -6px;
	right: 7px;
}

.datetimepicker-dropdown-bottom-right:before {
	top: -7px;
	left: 6px;
}

.datetimepicker-dropdown-bottom-right:after {
	top: -6px;
	left: 7px;
}

.datetimepicker-dropdown-top-left:before {
	bottom: -7px;
	right: 6px;
}

.datetimepicker-dropdown-top-left:after {
	bottom: -6px;
	right: 7px;
}

.datetimepicker-dropdown-top-right:before {
	bottom: -7px;
	left: 6px;
}

.datetimepicker-dropdown-top-right:after {
	bottom: -6px;
	left: 7px;
}

.datetimepicker > div {
	display: none;
}

.datetimepicker.minutes div.datetimepicker-minutes {
	display: block;
}

.datetimepicker.hours div.datetimepicker-hours {
	display: block;
}

.datetimepicker.days div.datetimepicker-days {
	display: block;
}

.datetimepicker.months div.datetimepicker-months {
	display: block;
}

.datetimepicker.years div.datetimepicker-years {
	display: block;
}

.datetimepicker table {
	margin: 0;
}

.datetimepicker  td,
.datetimepicker th {
	text-align: center;
	width: 20px;
	height: 20px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	border: none;
}

.table-striped .datetimepicker table tr td,
.table-striped .datetimepicker table tr th {
	background-color: transparent;
}

.datetimepicker table tr td.minute:hover {
	background: #eeeeee;
	cursor: pointer;
}

.datetimepicker table tr td.hour:hover {
	background: #eeeeee;
	cursor: pointer;
}

.datetimepicker table tr td.day:hover {
	background: #eeeeee;
	cursor: pointer;
}

.datetimepicker table tr td.old,
.datetimepicker table tr td.new {
	color: #999999;
}

.datetimepicker table tr td.disabled,
.datetimepicker table tr td.disabled:hover {
	background: none;
	color: #999999;
	cursor: default;
}

.datetimepicker table tr td.today,
.datetimepicker table tr td.today:hover,
.datetimepicker table tr td.today.disabled,
.datetimepicker table tr td.today.disabled:hover {
	background-color: #fde19a;
	background-image: -moz-linear-gradient(top, #fdd49a, #fdf59a);
	background-image: -ms-linear-gradient(top, #fdd49a, #fdf59a);
	background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#fdd49a), to(#fdf59a));
	background-image: -webkit-linear-gradient(top, #fdd49a, #fdf59a);
	background-image: -o-linear-gradient(top, #fdd49a, #fdf59a);
	background-image: linear-gradient(to bottom, #fdd49a, #fdf59a);
	background-repeat: repeat-x;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#fdd49a', endColorstr='#fdf59a', GradientType=0);
	border-color: #fdf59a #fdf59a #fbed50;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
}

.datetimepicker table tr td.today:hover,
.datetimepicker table tr td.today:hover:hover,
.datetimepicker table tr td.today.disabled:hover,
.datetimepicker table tr td.today.disabled:hover:hover,
.datetimepicker table tr td.today:active,
.datetimepicker table tr td.today:hover:active,
.datetimepicker table tr td.today.disabled:active,
.datetimepicker table tr td.today.disabled:hover:active,
.datetimepicker table tr td.today.active,
.datetimepicker table tr td.today:hover.active,
.datetimepicker table tr td.today.disabled.active,
.datetimepicker table tr td.today.disabled:hover.active,
.datetimepicker table tr td.today.disabled,
.datetimepicker table tr td.today:hover.disabled,
.datetimepicker table tr td.today.disabled.disabled,
.datetimepicker table tr td.today.disabled:hover.disabled,
.datetimepicker table tr td.today[disabled],
.datetimepicker table tr td.today:hover[disabled],
.datetimepicker table tr td.today.disabled[disabled],
.datetimepicker table tr td.today.disabled:hover[disabled] {
	background-color: #fdf59a;
}

.datetimepicker table tr td.today:active,
.datetimepicker table tr td.today:hover:active,
.datetimepicker table tr td.today.disabled:active,
.datetimepicker table tr td.today.disabled:hover:active,
.datetimepicker table tr td.today.active,
.datetimepicker table tr td.today:hover.active,
.datetimepicker table tr td.today.disabled.active,
.datetimepicker table tr td.today.disabled:hover.active {
	background-color: #fbf069;
}

.datetimepicker table tr td.active,
.datetimepicker table tr td.active:hover,
.datetimepicker table tr td.active.disabled,
.datetimepicker table tr td.active.disabled:hover {
	background-color: #006dcc;
	background-image: -moz-linear-gradient(top, #0088cc, #0044cc);
	background-image: -ms-linear-gradient(top, #0088cc, #0044cc);
	background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
	background-image: -webkit-linear-gradient(top, #0088cc, #0044cc);
	background-image: -o-linear-gradient(top, #0088cc, #0044cc);
	background-image: linear-gradient(to bottom, #0088cc, #0044cc);
	background-repeat: repeat-x;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0088cc', endColorstr='#0044cc', GradientType=0);
	border-color: #0044cc #0044cc #002a80;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
	color: #ffffff;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

.datetimepicker table tr td.active:hover,
.datetimepicker table tr td.active:hover:hover,
.datetimepicker table tr td.active.disabled:hover,
.datetimepicker table tr td.active.disabled:hover:hover,
.datetimepicker table tr td.active:active,
.datetimepicker table tr td.active:hover:active,
.datetimepicker table tr td.active.disabled:active,
.datetimepicker table tr td.active.disabled:hover:active,
.datetimepicker table tr td.active.active,
.datetimepicker table tr td.active:hover.active,
.datetimepicker table tr td.active.disabled.active,
.datetimepicker table tr td.active.disabled:hover.active,
.datetimepicker table tr td.active.disabled,
.datetimepicker table tr td.active:hover.disabled,
.datetimepicker table tr td.active.disabled.disabled,
.datetimepicker table tr td.active.disabled:hover.disabled,
.datetimepicker table tr td.active[disabled],
.datetimepicker table tr td.active:hover[disabled],
.datetimepicker table tr td.active.disabled[disabled],
.datetimepicker table tr td.active.disabled:hover[disabled] {
	background-color: #0044cc;
}

.datetimepicker table tr td.active:active,
.datetimepicker table tr td.active:hover:active,
.datetimepicker table tr td.active.disabled:active,
.datetimepicker table tr td.active.disabled:hover:active,
.datetimepicker table tr td.active.active,
.datetimepicker table tr td.active:hover.active,
.datetimepicker table tr td.active.disabled.active,
.datetimepicker table tr td.active.disabled:hover.active {
	background-color: #003399;
}

.datetimepicker table tr td span {
	display: block;
	width: 23%;
	height: 54px;
	line-height: 54px;
	float: left;
	margin: 1%;
	cursor: pointer;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

.datetimepicker .datetimepicker-hours span {
	height: 26px;
	line-height: 26px;
}

.datetimepicker .datetimepicker-hours table tr td span.hour_am,
.datetimepicker .datetimepicker-hours table tr td span.hour_pm {
	width: 14.6%;
}

.datetimepicker .datetimepicker-hours fieldset legend,
.datetimepicker .datetimepicker-minutes fieldset legend {
	margin-bottom: inherit;
	line-height: 30px;
}

.datetimepicker .datetimepicker-minutes span {
	height: 26px;
	line-height: 26px;
}

.datetimepicker table tr td span:hover {
	background: #eeeeee;
}

.datetimepicker table tr td span.disabled,
.datetimepicker table tr td span.disabled:hover {
	background: none;
	color: #999999;
	cursor: default;
}

.datetimepicker table tr td span.active,
.datetimepicker table tr td span.active:hover,
.datetimepicker table tr td span.active.disabled,
.datetimepicker table tr td span.active.disabled:hover {
	background-color: #006dcc;
	background-image: -moz-linear-gradient(top, #0088cc, #0044cc);
	background-image: -ms-linear-gradient(top, #0088cc, #0044cc);
	background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
	background-image: -webkit-linear-gradient(top, #0088cc, #0044cc);
	background-image: -o-linear-gradient(top, #0088cc, #0044cc);
	background-image: linear-gradient(to bottom, #0088cc, #0044cc);
	background-repeat: repeat-x;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0088cc', endColorstr='#0044cc', GradientType=0);
	border-color: #0044cc #0044cc #002a80;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
	color: #ffffff;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

.datetimepicker table tr td span.active:hover,
.datetimepicker table tr td span.active:hover:hover,
.datetimepicker table tr td span.active.disabled:hover,
.datetimepicker table tr td span.active.disabled:hover:hover,
.datetimepicker table tr td span.active:active,
.datetimepicker table tr td span.active:hover:active,
.datetimepicker table tr td span.active.disabled:active,
.datetimepicker table tr td span.active.disabled:hover:active,
.datetimepicker table tr td span.active.active,
.datetimepicker table tr td span.active:hover.active,
.datetimepicker table tr td span.active.disabled.active,
.datetimepicker table tr td span.active.disabled:hover.active,
.datetimepicker table tr td span.active.disabled,
.datetimepicker table tr td span.active:hover.disabled,
.datetimepicker table tr td span.active.disabled.disabled,
.datetimepicker table tr td span.active.disabled:hover.disabled,
.datetimepicker table tr td span.active[disabled],
.datetimepicker table tr td span.active:hover[disabled],
.datetimepicker table tr td span.active.disabled[disabled],
.datetimepicker table tr td span.active.disabled:hover[disabled] {
	background-color: #0044cc;
}

.datetimepicker table tr td span.active:active,
.datetimepicker table tr td span.active:hover:active,
.datetimepicker table tr td span.active.disabled:active,
.datetimepicker table tr td span.active.disabled:hover:active,
.datetimepicker table tr td span.active.active,
.datetimepicker table tr td span.active:hover.active,
.datetimepicker table tr td span.active.disabled.active,
.datetimepicker table tr td span.active.disabled:hover.active {
	background-color: #003399;
}

.datetimepicker table tr td span.old {
	color: #999999;
}

.datetimepicker th.switch {
	width: 145px;
}

.datetimepicker th span.glyphicon {
	pointer-events: none;
}

.datetimepicker thead tr:first-child th,
.datetimepicker tfoot th {
	cursor: pointer;
}

.datetimepicker thead tr:first-child th:hover,
.datetimepicker tfoot th:hover {
	background: #eeeeee;
}

.input-append.date .add-on i,
.input-prepend.date .add-on i,
.input-group.date .input-group-addon span {
	cursor: pointer;
	width: 14px;
	height: 14px;
}