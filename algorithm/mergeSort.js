const mergeSort = arr => {
    if (arr.length < 2) return arr;

    const mid = arr.length >> 1;
    const l = mergeSort(arr.slice(0, mid));
    const r = mergeSort(arr.slice(mid, arr.length));
    return Array.from({length: l.length + r.length}, () => {
        if (!l.length) return r.shift();
        else if (!r.length) return l.shift();
        else return l[0] > r[0] ? r.shift() : l.shift();
    })
}

console.log(mergeSort([1, 9, 8, 5, 6, 7, 4, 3, 2]));
