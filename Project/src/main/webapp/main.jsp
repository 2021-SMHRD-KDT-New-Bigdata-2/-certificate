<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Main</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="assets/css/style.min.css">
<link rel="stylesheet" href="assets/css/modules.css">
</head>
<body>
	<!--페이지 사진-->
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고, 회원가입, 로그인-->
		<header>
			<h3>Studynet</h3>
			<nav>
				<span><a href="join.jsp">회원가입</a></span> <span><a
					href="login.jsp">로그인</a></span>
			</nav>
		</header>
		
			<!--로고, 회원가입, 로그인-->
			<div id="main">
				<h1>언택트 시대, 최고의 선택</h1>
				<br>
				<p>블라블라</p>
			</div>
	</div>
	<div class="info">
		<div>
			<section>
				<div class="linkTitle">
					<a class="link" href="lecture.jsp">Lecture</a>
				</div>
			</section>

			<section class="MOD_LIGHTBOXIMGX4">
				<div data-layout="_r">
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/300/300?image=55" class="AP_lightbox">
							<figure>
								<img src="https://unsplash.it/300/300?image=55" alt="">
								<figcaption>Fig1. Image Caption</figcaption>
							</figure>
						</a>
					</div>
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/800/600?image=56" class="AP_lightbox"
							aria-haspopup="true">
							<figure>
								<img src="https://unsplash.it/300/300?image=56" alt="">
								<figcaption>Fig2. Image Caption</figcaption>
							</figure>
						</a>
					</div>
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/800/600?image=57" class="AP_lightbox"
							aria-haspopup="true">
							<figure>
								<img src="https://unsplash.it/300/300?image=57" alt="">
								<figcaption>Fig3. Image Caption</figcaption>
							</figure>
						</a>
					</div>
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/800/600?image=58" class="AP_lightbox"
							aria-haspopup="true">
							<figure>
								<img src="https://unsplash.it/300/300?image=58" alt="">
								<figcaption>Fig4. Image Caption</figcaption>
							</figure>
						</a>
					</div>
				</div>
			</section>
		</div>
		<div>
			<!-- 탑4 불러오고 싶으면 jsp로 for문 작성하기-->
			<section class="MOD_FEATURE">
				<div data-layout="_r">
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
								<p class="MOD_FEATURE_Description">Lorem ipsum dolor sit
									amet, consectetur adipiscing elit, sed do eiusmod tempor
									incididunt ut labore et dolore magna aliqua</p>
							</div>
						</a>
					</div>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
								<p class="MOD_FEATURE_Description">Lorem ipsum dolor sit
									amet, consectetur adipiscing elit, sed do eiusmod tempor
									incididunt ut labore et dolore magna aliqua</p>
							</div>
						</a>
					</div>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
								<p class="MOD_FEATURE_Description">Lorem ipsum dolor sit
									amet, consectetur adipiscing elit, sed do eiusmod tempor
									incididunt ut labore et dolore magna aliqua</p>
							</div>
						</a>
					</div>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
								<p class="MOD_FEATURE_Description">Lorem ipsum dolor sit
									amet, consectetur adipiscing elit, sed do eiusmod tempor
									incididunt ut labore et dolore magna aliqua</p>
							</div>
						</a>
					</div>
				</div>
			</section>
		</div>
		<div>
			<table style="margin: auto;">
				<tr>
					<th colspan="4"><a href="study.jsp">GroupStudy</a></th>
				</tr>
				<tr>
					<td><a href="#" class="info"> 스터디정보1 </a></td>
					<td><a href="#" class="info"> 스터디정보2 </a></td>
					<td><a href="#" class="info"> 스터디정보3 </a></td>
					<td><a href="#" class="info"> 스터디정보4 </a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>