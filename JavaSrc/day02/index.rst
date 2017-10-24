=============================
Day 02
=============================

.. contents:: 
   :depth: 1
   :local:
   
   
최소 신장 트리
=========================

- `Prim 예제 <https://github.com/prolecture/problems/blob/master/JavaSrc/day01/최소신장트리_Prim.java>`_
- `Kruskal 예제 <https://github.com/prolecture/problems/blob/master/JavaSrc/day01/최소신장트리_Kruskal.java>`_

---------

최단 거리
=========================

- `Dijkstra 예제 <https://github.com/prolecture/problems/blob/master/JavaSrc/day02/최단거리_Dijkstra.java>`_

---------

최소 연료 비용
=========================

.. tip::

    `최단 경로 참고 <http://algocoding.net/graph/shortest_path/index.html>`_


.. figure:: img/delta.png
   :scale: 60%
   :align: center
   
   < (x, y)의 상하좌우 인접한 셀 >


- MAP[][]: 지도 정보
- D[][]: 시작점(좌상단)에서 각 정점까지의 최단 거리 

.. figure:: img/relaxation.png
    :scale: 60%
    :align: center

    < (x, y)의 상하좌우 인접한 셀 >

.. code-block:: java

    int diff = (MAP[tx][ty] > MAP[x][y]) ? MAP[tx][ty] - MAP[x][y] + 1: 1;
     
    if(D[tx][ty] > D[x][y] + diff)
        D[tx][ty] = D[x][y] + diff;


- `BFS 예제 <https://github.com/prolecture/problems/blob/master/JavaSrc/day02/최소연료비용_BFS.java>`_        