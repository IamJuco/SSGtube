<img src="https://capsule-render.vercel.app/api?type=waving&color=6FA8DC&height=300&section=header&text=Youtube" />
<div align="center">

## [2024] 안드로이드 유튜브 앱 제작  
유튜브 API를 활용한 동영상 리스트 어플입니다.<br>
사용자에게 YouTube의 현재 인기 및 새로운 콘텐츠를 중점적으로 보여주고, 콘텐츠를 검색하고, 보관함에서 저장 및 삭제를 할 수 있습니다.
</div>

## 목차
- [개요](#개요)
- [기능 설명](#기능-설명)
- [팀원 소개](#팀원-소개)
- [참고 자료](#참고-자료)

## 개요
- 프로젝트 이름: `쓱튜브 (SSG Tube)`
- 프로젝트 기간: `2024-05-13 ~ 2024-05-23`
- 프로젝트 핵심기술
    - `MVVM`
    - `ViewModel,Live Data`
    - `Repository Pattern`
    - `Retrofit`
    - `Bottom Navigation View`
    - `Shared Preference`
    - `Coroutine`

- 기술 스택<br>
<br>
<img src="https://img.shields.io/badge/android-34A853?style=for-the-badge&logo=android&logoColor=white"/>
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=Git&logoColor=white"/>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/>
<img src="https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white"/>
<img src="https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white/">
<img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>


 
## 기능 설명

<table>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/b271327b-12a3-4a19-a332-e189c3aaec23" style="width:1000px;"/>
            <p align="center">Home Fragment</p>
        </td>
        <td>
            <p align="center">홈 프래그먼트에서는 유튜브 API의 엔드포인트를 활용하여 가장 인기있는 동영상, 각 카테고리별 동영상, 각 카테고리에 대한 채널을 띄워줍니다.</p>
        </td>
        <td>
            <p align="center">Youtube API, spinner widget, fragment, adapter, recyclerView, bottom navigation view, ViewModel</p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/0362b40f-5a6b-49a7-b4ac-f3e542947fe6" style="width:1000px;"/>
            <p align="center">Search Fragment 1</p>
        </td>
        <td>
            <p align="center">검색 프래그먼트에서는 사용자가 입력한 검색에 대한 유튜브 동영상을 띄워줍니다. 스크롤 기능을 추가하여 페이지가 넘어갈 때마다 추가적인 데이터 요청을 할 수 있습니다. 또한, 플로팅 버튼을 추가하여 클릭시 리사이클러 뷰의 맨 위쪽으로 이동할 수 있습니다.</p>
        </td>
        <td>
            <p align="center">floating button, Infinite scrollView, fragment, adapter, recylerView, ViewModel</p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/bf93add9-6859-4b37-8174-53c8fba5d190" style="width:1000px;"/>
            <p align="center">Search Fragment 2</p>
        </td>
        <td>
            <p align="center">검색 프래그먼트에서는 검색창 아래에 버튼을 추가하였습니다. 각 버튼은 API 요청값에 대한 order 값을 다르게 받아오도록 구현하였습니다. 받아온 동영상에 대하여 인기순, 최신순, 평점순으로 필터링을 하여 순서를 재배치할 수 있습니다.</p>
        </td>
        <td>
            <p align="center">API, Retrofit, okHttpClient, ripple</p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/5fe79faf-c7b5-47e6-8cf6-cc6df3dd82a1" style="width:1000px;"/>
            <p align="center">Detail Fragment</p>
        </td>
        <td>
            <p align="center">홈 프래그먼트나 서치 프래그먼트에서는 각 비디오를 클릭하면 Click 이벤트를 발생시켜 디테일 프래그먼트로 이동할 수 있습니다.이동하는 과정에서 애니메이션 효과를 추가했습니다.또한, 디테일 프래그먼트 안에서 하트를 클릭하게 되면 좋아요가 반영되고 해당 비디오는 마이페이지 프래그먼트에 전달되어 저장됩니다. 이후 좋아요를 취소하면 마이페이지 프래그먼트에서 삭제할 수 있고, 검색 프래그먼트나 홈 프래그먼트로 돌아와 해당 동영상을 클릭했을 때 좋아요 취소가 반영되도록 구현하였습니다. </p>
        </td>
        <td>
            <p align="center">fragment, animation, Toast Message, SharedPreference, SharedViewModel </p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/39c0665e-bc20-4d88-b807-e7393ee11613"style="width:1000px;"/>
            <p align="center">Detail Fragment</p>
        </td>
        <td>
            <p align="center">디테일 프래그먼트에서는 좋아요 기능 뿐만 아니라 공유 기능 또한 구현하였습니다.<br>공유 기능을 통해 다른 앱으로 비디오의 링크를 전송할 수 있습니다.</p>
        </td>
        <td>
            <p align="center">Intent</p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/d4fabdd7-7bc3-4e86-a007-67203285c288"style="width:1000px;"/>
            <p align="center">Search Fragment</p>
        </td>
        <td>
            <p align="center">검색창에 사용자가 원하는 내용을 입력하면 그에 맞는 유튜브 동영상을 띄울 수 있습니다.</p>
        </td>
        <td>
            <p align="center">API</p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://github.com/juseonghyun/SSGtube/assets/115936076/b1ff5e75-a868-494d-8729-222aad97d4ba" style="width:1000px;"/>
            <p align="center">Detail Fragment</p>
        </td>
        <td>
            <p align="center">홈 프래그먼트에서 동영상을 클릭하면 디테일 프래그먼트로 이동할 수 있습니다.또한, 내용이 긴 경우를 대비하여 스크롤 기능을 추가하였습니다.</p>
        </td>
        <td>
            <p align="center">scrollview</p>
        </td>
    </tr>   
</table>

## 팀원 소개 
|이름|역할 및 기능 분담|
|:---:|:---:|
|**주성현**|Home Fragment, Bottom navigation View, MVVM, Repository Pattern,|
|**안진혁**|공통된 ID 를 통한 서로 다른 API 값 연결, Detail Fragment ... 각자 더 추가해주시면 됩니다!|
|**박세영**|Search Fragment, MyPage Fragment, Infinite ScrollView, Shared View Model|
|**유혜정**|PPT 제작 및 앱 디자인 개선 ... 각자 더 추가해주시면 됩니다!|


## 참고 자료
- [노션 자료](https://teamsparta.notion.site/88-8-920d10d4dd5f4ee5a6efb8e28e00e61b)

<img src="https://capsule-render.vercel.app/api?type=waving&color=6FA8DC&height=300&section=footer&text=감사합니다&fontSize=30" />



