=============================
Day 03
=============================

.. contents:: 
   :depth: 1
   :local:

팩토리얼
=========================

- `팩토리얼 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/팩노리얼.java>`_

타일 붙이기
=========================

.. figure:: img/tile1.png
    :scale: 60%
    :align: center

    < 3개의 타일 >

.. figure:: img/tile2.png
    :scale: 60%
    :align: center
    
    < 길이 1 = 1가지, 길이 2 = 3가지 >

.. figure:: img/tile3.png
    :scale: 60%
    :align: center
    
    < 길이 3 = 길이1 + 길이2 >

.. figure:: img/tile4.png
    :scale: 60%
    :align: center

    < 길이 3에 대한 모든 방법 >
    
.. figure:: img/tile5.png
    :scale: 60%
    :align: center
    
    < 길이 n >

- `타일 붙이기(재귀) <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/타일붙이기_재귀.java>`_
- `타일 붙이기(반복) <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/타일붙이기_반복.java>`_


네 개의 수
=========================

.. figure:: img/fourNumber1.png
    :scale: 60%
    :align: center

    < 모든 경우의 수 >

- `brute-force(중복순열) <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/네개의수_brute.java>`_
- `재귀 + 메모 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/네개의수_재귀메모.java>`_
- `반복 + 메모 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/네개의수_반복.java>`_

.. figure:: img/fourNumber2.png
    :scale: 60%
    :align: center
   
    < 문제들 간의 관계 >

점화식은 :math:`f(n) = f(n-1) + f(n-2) + f(n-3)` 이 된다.  주의할 것은 기저 사례는 :math:`f(0) = 1` 이다. 

메모이제이션을 통해 중복된 계산 작업을 줄일 수 있다.

- `재귀-메모 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/네개의수_재귀메모.java>`_

.. figure:: img/fourNumber3.png
    :scale: 60%
    :align: center

    < 테이블 채우기 >    

- `반복 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/네개의수_반복.java>`_

---------

최장 증가 부분 수열
=========================

.. code-block:: console

    6      // 자료수
    1 6 3 4 5 2

각 자료로 끝나는 가장 긴 증가 수열들은 다음과 같다.

- 1로 끝나는 증가 수열: (1)
- 6로 끝나는 증가 수열: (1, 6)
- 3로 끝나는 증가 수열: (1, 3)
- 4로 끝나는 증가 수열: (1, 4), (1, 3, 4)
- 5로 끝나는 증가 수열: (1, 5), (1, 3, 5), (1, 4, 5), (1, 3, 4, 5)
- 2로 끝나는 증가 수열: (1, 2) 

5로 끝나는 증가 수열들은 1, 3, 4 로 끝나는 증가 수열들에 5를 추가 하면 된다. 6은 5보다 큰 값이기 때문에 6으로 끝나는 증가 수열 뒤에 5를 붙일 수 없다.   


구간트리 - RMQ(Range Maximum Query)

.. figure:: img/LIS_seg1.png
    :scale: 60%
    :align: center

.. figure:: img/LIS_seg2.png
    :scale: 60%
    :align: center

.. figure:: img/LIS_seg3.png
    :scale: 60%
    :align: center

.. figure:: img/LIS_seg4.png
    :scale: 60%
    :align: center

.. figure:: img/LIS_seg5.png
    :scale: 60%
    :align: center

.. figure:: img/LIS_seg6.png
    :scale: 60%
    :align: center


- `DP 반복 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/LIS_DP.java>`_
- `이진 탐색 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/LIS_Binary.java>`_
- `구간 트리 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/LIS_구간트리.java>`_

최장 거리
=========================

- `최장 거리 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/최장거리.java>`_


오른쪽 아래 이동
=========================
- `재귀 + 메모 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/오른쪽아래이동3_재귀.java>`_    
- `반복 + 메모 <https://github.com/prolecture/problems/blob/master/JavaSrc/day03/오른쪽아래이동3.java>`_



